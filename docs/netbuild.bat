msbuild /t:Clean Revenj.sln
msbuild /t:Rebuild /p:Configuration=Release Server\Revenj.Http\Revenj.Http.csproj
