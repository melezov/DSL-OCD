package com.dslplatform.ocd.test;

import fi.iki.elonen.NanoHTTPD;

public class RevenjRunner extends NanoHTTPD {
    private final String serverAddress;
    private final int serverPort;
    private final String stopUrl;

    private RevenjRunner(
            final String serverAddress,
            final int serverPort,
            final String runnerAddress,
            final int runnerPort,
            final String stopUrl) throws Exception {
        super(runnerAddress, runnerPort);
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.stopUrl = stopUrl;

        this.webServer = startBoth();
    }

    private Object webServer;

    private Object startBoth() throws Exception {
        System.out.println("Starting Revenj runner ...");
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);

        System.out.println("Starting Revenj ...");
        final Class<?> clazz = Class.forName("net.revenj.server.WebServer");
        final Object instance = clazz.getConstructor(String.class, int.class).newInstance(serverAddress, serverPort);
        clazz.getMethod("start").invoke(instance);
        return instance;
    }

    private void stopBoth() throws Exception {
        System.out.println("Stopping Revenj ...");
        final Class<?> clazz = Class.forName("net.revenj.server.WebServer");
        clazz.getMethod("shutdown").invoke(webServer);

        System.out.println("Stopping Revenj runner ...");
        stop();
    }

    private void scheduleShutdown(final long delayMs) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMs);
                    stopBoth();
                }
                catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public Response serve(final IHTTPSession session) {
        if (session.getUri().substring(1).equals(stopUrl)) {
            scheduleShutdown(1000);
        }
        return newFixedLengthResponse("OK");
    }

    public static void main(final String[] args) throws Exception {
        try {
            final String serverAddress = args[0];
            final int serverPort = Integer.parseInt(args[1]);
            final String runnerAddress = args[2];
            final int runnerPort = Integer.parseInt(args[3]);
            final String stopUrl = args[4];

            new RevenjRunner(serverAddress, serverPort, runnerAddress, runnerPort, stopUrl);
        }
        catch (final IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
