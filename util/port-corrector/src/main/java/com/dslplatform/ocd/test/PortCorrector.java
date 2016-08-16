package com.dslplatform.ocd.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

/**
 * An ad-hoc class to be used at runtime to check if any of the predefined ports
 * in 'projectNamesAndPortsRepository.properties' are in use.
 */
public class PortCorrector {
    private static final Random random = new Random();
    private final String propertiesFilename;
    private final Properties props;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("No properties file provided.");
            return;
        }

        String propertiesFilename = args[0];

        new PortCorrector(propertiesFilename).sanitizePorts();
    }

    public PortCorrector(String propertiesFilename) throws IOException {
        this.propertiesFilename = propertiesFilename;
        this.props = new Properties();
        props.load(new FileInputStream(propertiesFilename));
    }

    private void sanitizePorts() throws IOException {
        Map<String, String> newValues = new HashMap<String, String>();
        Set<String> encountered = new HashSet<String>();
        for (Object key : props.keySet()) {
            try {
                String projectShortName = projectShortName(props, (String) key);
                String host = host(props, (String) key);
                Integer port = port(props, (String) key);
                Integer oldPort = port;
                if (eitherNull(projectShortName, host, port)) continue;

                if (encountered.contains(projectShortName)) continue;
                encountered.add(projectShortName);

                if (!portIsFree(projectShortName, host, port)) {
                    while (!portIsFree(projectShortName, host, port)) {
                        port = freeRandomPort(projectShortName, host);
                    }
                    System.out.println("Port clash detected. Port for project: " + projectShortName + " at host: " + host + " changed from: " + oldPort + " to " + port);
                    newValues.put(projectShortName + ".port", port.toString());
                }
            } catch (Exception e) {
                continue;
            }
        }

        props.putAll(newValues);
        props.store(new java.io.FileOutputStream(propertiesFilename), "Generated mappings for project names to their server ports.");
    }

    private boolean portIsFree(String projectShortName, String host, int port) {
        return portIsNotReservedInOCDConfig(projectShortName, host, port) && socketIsFree(host, port);
    }

    private boolean portIsNotReservedInOCDConfig(String projectShortName, String host, int port) {
        for (Map.Entry<Object, Object> e : props.entrySet()) {
            String key = (String) e.getKey();
            String value = (String) e.getValue();
            if (!projectShortName.equals(projectShortName(props, key))
                    && host.equals(host(props, key))
                    && port == port(props, key)) {
                // Port is reserved
                return false;
            }
        }
        return true;
    }

    private boolean socketIsFree(String host, int port) {
        Socket s = null;
        try {
            s = new Socket(host, port);
            return false;
        } catch (Exception e) {
            return true;
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private int freeRandomPort(String projectShortName, String host) {
        int nextPort = random.nextInt(10000) + 10000;
        if (portIsFree(projectShortName, host, nextPort))
            return nextPort;
        return freeRandomPort(projectShortName, host);
    }

    private static String projectShortName(Properties props, String key) {
        String projectShortName = null;
        if (key.endsWith(".host")) {
            projectShortName = key.replaceAll("\\.host$", "");
        }
        if (key.endsWith(".port")) {
            projectShortName = key.replaceAll("\\.port$", "");
        }
        return projectShortName;
    }

    private static String host(Properties props, String key) {
        String projectShortName = projectShortName(props, key);
        if (projectShortName == null) return null;
        return (String) props.get(projectShortName + ".host");
    }

    private static Integer port(Properties props, String key) {
        String projectShortName = projectShortName(props, key);
        if (projectShortName == null) return null;
        return Integer.parseInt((String) props.get(projectShortName + ".port"));
    }

    private static boolean eitherNull(Object... objs) {
        if (objs == null) return false;
        for (Object obj : objs) {
            if (obj == null) return true;
        }
        return false;
    }
}
