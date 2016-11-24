DSL-OCD: Obsessive-Compulsive Testing for DSL Platform
======================================================

## Staging

- **dsl-clc** - (**builds** from [dsl-platform fork](https://github.com/dsl-platform/dsl-compiler-client) of `dsl-compiler
- **dsl-compiler** - (**downloads** from [dsl-platform downloads](https://compiler.dsl-platform.com:8443/platform/download/dsl-compiler.zip))
- **dsl-json** - (**builds** from [dsl-platform fork](https://github.com/dsl-platform/dsl-json) of `dsl-json`)
- **dsl-client-java** - (**builds** from [dsl-platform fork](https://github.com/dsl-platform/dsl-client-java) of `dsl-client-java`)
- **revenj.java** - (**builds** from [dsl-platform fork](https://github.com/dsl-platform/revenj) of `revenj/java`)
- **revenj.scala** - (**builds** from [dsl-platform fork](https://github.com/dsl-platform/revenj) of `revenj/scala`)
client/CommandLineClient`)
- **revenj.net** - (**downloads** from [ngs releases](https://github.com/ngs-doo/revenj/releases) page `revenj/csharp`)

To build and download:

    cd ~/DSL-OCD/staging
    sbt run


## Deploying

For **deploying** `~/DSL-OCD-Target`:
    
    nano ~/.config/DSL-OCD/ocd.config


Deploy staging artifacts & tests:

    rm -rf ~/DSL-OCD-Target
    cd ~/DSL-OCD/test
    sbt run

## Running

For **running** `~/DSL-OCD-Target`:

    nano ~/.config/DSL-OCD/test.config

Run tests:

    cd ~/DSL-OCD-Target

	# optionally clean all databases, to see all tasks `ant -p` 
	ant db-drop
	
	# run all tasks, pipe into log in case of strange errors
	ant all > report/all.log 2>&1
	
	# create the website under `~/DSL-OCD-Target/report/site/index.html`
	ant report
