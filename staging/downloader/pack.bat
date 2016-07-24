@echo off
setlocal
pushd "%~dp0"

set SBT_OPTS="-Duser.home=..\repositories\.home"

sbt packCopyDependencies
del dependencies\downloader-*.jar

popd