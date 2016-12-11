@echo off
setlocal
pushd "%~dp0"

set OCDVER=0.2.2

time /T

for /d %%d in ("%USERPROFILE%\.ivy2\local\com.dslplatform.ocd.*") do rmdir /S /Q "%%~fd"
rmdir /S /Q "%USERPROFILE%\.m2\repository\com\dslplatform\ocd"

move "..\templates\staging\.home" "tmp-home"
rmdir /S /Q "..\templates\staging"
mkdir "..\templates\staging"
move "tmp-home" "..\templates\staging\.home"

echo ### UTIL - generator ###
cd "..\util\generator"
call sbt clean publishLocal

echo ### UTIL - ping ###
cd "..\ping"
call sbt clean publishLocal
copy /Y "target\dsl-ocd-util-ping-%OCDVER%.jar" "..\..\templates\tools\build"

echo ### UTIL - port corrector ###
cd "..\port-corrector"
call sbt clean publishLocal
copy /Y "target\dsl-ocd-util-port-corrector-%OCDVER%.jar" "..\..\templates\tools\build"

echo ### UTIL - report ###
cd "..\report"
call sbt clean publishLocal
copy /Y "target\dsl-ocd-util-report-%OCDVER%.jar" "..\..\templates\tools\build"

echo ### UTIL - revenj-runner ###
cd "..\revenj-runner"
call sbt clean publishLocal assembly
copy /Y "target\DSL-OCD-Util-Revenj-Runner-assembly-%OCDVER%.jar" "..\..\templates\tools\runtime\revenj-runner\dsl-ocd-util-revenj-runner-%OCDVER%.jar"

echo ### UTIL - testing ###
cd "..\testing"
call sbt clean publishLocal
copy /Y "target\dsl-ocd-util-testing-%OCDVER%.jar" "..\..\templates\tools\test"

echo ### MODEL - generator ###
cd "..\..\model\generator"
call sbt clean run

echo ### MODEL - kinds ###
cd "..\kinds"
call sbt clean publishLocal

echo ### MODEL - boxes ###
cd "..\boxes"
call sbt clean publishLocal

echo ### MODEL - types ###
cd "..\types"
call sbt clean publishLocal

echo ### MODEL - dsls ###
cd "..\dsls"
call sbt clean publishLocal

echo ### MODEL - scalas ###
cd "..\scalas"
call sbt clean publishLocal

echo ### MODEL - javas ###
cd "..\javas"
call sbt clean publishLocal

echo ### MODEL - java-asserts ###
cd "..\java-asserts"
call sbt clean publishLocal

echo ### STAGING ###
cd "..\..\staging"
call sbt clean run

echo ### TEST ###
cd "..\test"
call sbt clean run

echo ### GIT ###
cd ..
git add --all
git commit -m "jars"

time /T

popd
