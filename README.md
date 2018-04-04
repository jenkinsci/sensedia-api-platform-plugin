# Introduction
This plugin will help you in the **continuous integration** and **delivery** for APIs, on Sensedia API Platform


# Documentation
Below we can see the three functions of the plugin. In few words, the function **get api json** download the api code to the workspace, the **quality analyst** validate the best practices, like hard coded end point, large paths and mandatory interceptors. At last, the **deploy** will be turn on the last API revision

## Get Api Json
Get the Api code, by Id. The **Id** can be seen at the Api URL on Sensedia API Platform Manager

https:/manager-demov3.sensedia.com/api-manager/#/apis/overview/**204**/revisions/2147756

• sensediaApiJson : int (ApiId)


    stage ("Checkout"){
		sensediaApiJson "204"
	}


## Quality Analyst
It validate the best practices on API. The **destination** search for hard coded endpoints, **logInterceptor** validates if log interceptor is too used and **resourceOutOfSize** if the path is too large

• sensediaApiQA: boolean (destination), boolean (logInterceptor), boolean (resourceOutOfSize)

    stage ("Quality Analyst"){
        sensediaApiQA(destination: true, logInterceptor: true, resourceOutOfSize: true)
    }

*If one of them is not set, the test will be skipped*

## Deploy
Performs a deployment in the enviroment

• sensediaApiJson : string(enviroment name)

    stage ("Production deploy"){
        sensediaApiDeploy(enviromentName: "Production")
    }

By default the Api revision deployed is the last

# Demo Pipeline
```mermaid
graph LR
A[Checkout] --> B[API Quality Analyst]

B --> C[Sandbox test]
C --> D[Production Deploy]
D --> E[Production test]
```

    node {
    stage ("Checkout"){
        checkout scm
        sensediaApiJson "204"
        bat "git.exe add *"
        bat 'git.exe commit -m "Automated Jenkins deploy"'
        bat "git.exe push origin HEAD:master"
    }
    stage ("Quality Analyst"){
        sensediaApiQA(destination: true, logInterceptor: true, resourceOutOfSize: true)
    }
    stage ("Sandbox test"){
        bat "newman run collection_sbox.json"
    }
    stage ("Production deploy"){
        sensediaApiDeploy(enviromentName: "Production")
    }
    stage ("Production test"){
        bat "newman run collection_prd.json"
    }
}
