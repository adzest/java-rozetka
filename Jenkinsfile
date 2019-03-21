pipeline {
    agent {
        label 'selenium'
    }
    stages {
        stage('SCM::Checkout') {
            steps {
                echo 'Init build sources here.'
            }
        }
        stage('BUILD::Products') {
            parallel {
                stage('Ezlo') {
                    steps {
                        echo 'Firmware build script here.'
                        echo 'NMA build script here.'
                        echo 'Web build script here.'
                        echo 'iOS build script here.'
                        echo 'Android build script here.'
                    }
                }
                stage('Zlink') {
                    steps {
                        echo 'Firmware build script here.'
                        echo 'NMA build script here.'
                        echo 'Web build script here.'
                        echo 'iOS build script here.'
                        echo 'Android build script here.'
                    }
                }
                stage('Vera') {
                    steps {
                        echo 'Firmware build script here.'
                        echo 'NMA build script here.'
                        echo 'Web build script here.'
                        echo 'iOS build script here.'
                        echo 'Android build script here.'
                    }
                }
                stage('Orange') {
                    steps {
                        echo 'Firmware build script here.'
                        echo 'NMA build script here.'
                        echo 'Web build script here.'
                        echo 'iOS build script here.'
                        echo 'Android build script here.'
                    }
                }
                stage('etc...') {
                    steps {
                        echo 'Firmware build script here.'
                        echo 'NMA build script here.'
                        echo 'Web build script here.'
                        echo 'iOS build script here.'
                        echo 'Android build script here.'
                    }
                }
                stage('AutomationFramework') {
                    steps {
                        sh(script: './gradlew clean')
                        sh(script: './gradlew build')
                    }
                }
            }
        }
        stage('TEST::AUTO::Unit') {
            parallel {
                stage("ETAF") {
                    steps {
                        sh(script: './gradlew Unit_Backend_NMA --info', returnStatus: true)
                        sh(script: './gradlew Unit_Backend_MMS --info', returnStatus: true)
                        sh(script: './gradlew Unit_Backend_OCS --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_OCS_Linux_CH --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_MMS_Android_CH --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_NMA_Android_CH --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_OCS_Android_CH --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_NMA_iOS_SF --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_Web_OCS_iOS_SF --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_App_Ezlo_Anroid --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_App_Ezlo_iOS --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_App_Zlink_Android --info', returnStatus: true)
                        sh(script: './gradlew Unit_UI_App_Zlink_iOS --info', returnStatus: true)
                        sh(script: './gradlew Unit_Utils --info', returnStatus: true)
                    }
                }
                stage("Firmware") {
                    steps {
                        echo 'Firmware unit tests.'
                    }
                }
                stage("NMA") {
                    steps {
                        echo 'NMA unit tests.'
                    }
                }
                stage("Web") {
                    steps {
                        echo 'AUTO::UI::Web unit tests.'
                    }
                }
                stage("iOS") {
                    steps {
                        echo 'AUTO::UI::iOS unit tests.'
                    }
                }
                stage("Android") {
                    steps {
                        echo 'AUTO::UI::Android unit tests.'
                    }
                }
            }
        }
        stage('TEST::AUTO::Integration') {
            parallel {
                stage("Ezlo") {
                    steps {
                        sh(script: "./gradlew Integration_Ezlo_Android --info", returnStatus: true)
                        sh(script: "./gradlew Integration_Ezlo_iOS --info", returnStatus: true)
                    }
                }
                stage("MMS") {
                    steps {
                        sh(script: "./gradlew Integration_MMS --info", returnStatus: true)
                    }
                }
                stage("NMA") {
                    steps {
                        sh(script: "./gradlew Integration_NMA  --info", returnStatus: true)
                    }
                }
                stage("OCS") {
                    steps {
                        sh(script: "./gradlew Integration_OCS  --info", returnStatus: true)
                    }
                }
                stage("Zlink") {
                    steps {
                        sh(script: "./gradlew Integration_Zlink_Android  --info", returnStatus: true)
                        sh(script: "./gradlew Integration_Zlink_iOS  --info", returnStatus: true)
                    }
                }
                stage("Utils") {
                    steps {
                        sh(script: "./gradlew Integration_Utils  --info", returnStatus: true)
                    }
                }
            }
        }
        stage('TEST::AUTO::System') {
            parallel {
                stage('UI::Web::OCS::Windows') {
                    steps {
                        sh(script: './gradlew System_UI_Web_OCS2_Win_CH --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Win_FF --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Win_IE --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Win_DG --info', returnStatus: true)
                    }
                }
                stage('UI::Web:OCS::Linux') {
                    steps {
                        sh(script: './gradlew System_UI_Web_OCS2_Linux_CH --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Linux_FF --info', returnStatus: true)
                    }
                }
                stage('UI::Web::OCS::MacOS') {
                    steps {
                        sh(script: './gradlew System_UI_Web_OCS2_Mac_CH --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Mac_FF --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS2_Mac_SF --info', returnStatus: true)
                    }
                }
                stage('UI::Web::OCS::Android') {
                    steps {
                        sh(script: './gradlew System_UI_Web_OCS2_Android_CH --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_NMA_Android_CH --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_MMS_Android_CH --info', returnStatus: true)
                    }
                }
                stage('UI::Web::OCS::iOS') {
                    steps {
                        sh(script: './gradlew System_UI_Web_NMA_iOS_SF --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_MMS_iOS_SF --info', returnStatus: true)
                        sh(script: './gradlew System_UI_Web_OCS_iOS_SF --info', returnStatus: true)
                    }
                }
                stage('UI::App::Ezlo') {
                    steps {
                        sh(script: './gradlew System_UI_App_Ezlo_Android --info', returnStatus: true)
                        sh(script: './gradlew System_UI_App_Ezlo_iOS --info', returnStatus: true)
                    }
                }
                stage('UI::App::Zlink') {
                    steps {
                        sh(script: './gradlew System_UI_App_Zlink_Android --info', returnStatus: true)
                        sh(script: './System_UI_App_Zlink_iOS System_UI_Web_NMA_iOS_FF --info', returnStatus: true)
                    }
                }
            }
        }
        stage('TEST::AUTO::Info') {
            steps {
                timeout(time: 15, unit: 'MINUTES') {
                    input message: 'Approve - Automation tests @AUTO?'
                }
            }
        }
        stage('TEST::QA::Manual') {
            steps {
                echo 'Do we need a Jira integration here e.g. list of Issues from Jira, ha? - Of course we could! ;)'
                timeout(time: 15, unit: 'MINUTES') {
                    input message: 'Approve - Functional manual tests @QA?'
                }
            }
        }
        stage('TEST::STAGE::System') {
            steps {
                sh(script: "./gradlew End2end_Web_OCS_Linux_CH --info", returnStatus: true)
                sh(script: "./gradlew End2end_Web_MMS_Linux_CH --info", returnStatus: true)
                sh(script: "./gradlew End2end_Web_NMA_Linux_CH --info", returnStatus: true)
                sh(script: "./gradlew End2end_App_Ezlo_Android --info", returnStatus: true)
                sh(script: "./gradlew End2end_App_Ezlo_iOS --info", returnStatus: true)
                sh(script: "./gradlew End2end_App_Zlink_Android --info", returnStatus: true)
                sh(script: "./gradlew End2end_App_EZlink_iOS --info", returnStatus: true)
                echo 'Regression tests on STAGING...'
                echo 'Performance tests on STAGING...'
            }
        }
        stage('TEST::STAGE::Info') {
            steps {
                timeout(time: 15, unit: 'MINUTES') {
                    input message: 'Approve testing @STAGING?'
                }
            }
        }
        stage('TEST::PROD::Acceptance') {
            parallel {
                stage('UI::Web::Windows') {
                    steps {
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Win_CH --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Win_FF --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Win_IE --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Win_DG --info', returnStatus: true)
                    }
                }
                stage('UI::Web::Linux') {
                    steps {
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Linux_CH --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Linux_FF --info', returnStatus: true)
                    }
                }
                stage('UI::Web::MacOS') {
                    steps {
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Mac_CH --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Mac_FF --info', returnStatus: true)
                        sh(script: './gradlew Acceptance_UI_Web_OCS2_Mac_SF --info', returnStatus: true)
                    }
                }
                stage('UI::Web::Android') {
                    steps {
                        echo 'Android browser tests.'
                        echo 'Android applications tests.'
                    }
                }
                stage('UI::Web::iOS') {
                    steps {
                        echo 'iOS browser tests.'
                        echo 'iOS applications tests.'
                    }
                }
                stage('UI::App::Ezlo') {
                    steps {
                        echo 'Ezlo app android tests.'
                        echo 'Ezlo app ios tests.'
                    }
                }
                stage('UI::App::Zlink') {
                    steps {
                        echo 'Zlink app android tests.'
                        echo 'Zlink app ios tests.'
                    }
                }
            }
        }
        stage('TEST::PROD::Info') {
            steps {
                timeout(time: 15, unit: 'MINUTES') {
                    input message: 'Approve - Acceptance tests @PROD?'
                }
            }
        }
        stage('RELEASE::Activities') {
            parallel {
                stage('Tag products') {
                    steps {
                        echo 'Add tags to sources'
                    }
                }
                stage('Update the official site') {
                    steps {
                        echo 'Do smthng.'
                    }
                }
                stage('Update the docs') {
                    steps {
                        echo 'Do smthng.'
                    }
                }
                stage('Update the marketing articles') {
                    steps {
                        echo 'Do smthng.'
                    }
                }
            }
        }
        stage('DEPLOY::Activities') {
            parallel {
                stage('Web::AWS') {
                    steps {
                        echo 'Deliver the Product.'
                    }
                }
                stage('iOS::AppStore') {
                    steps {
                        echo 'Deliver the Product.'
                    }
                }
                stage('Android::PlayMarket') {
                    steps {
                        echo 'Deliver the Product.'
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Copy categories.json'
            sh(script: 'if [ ! -d ${WORKSPACE}/"build/allure-results" ]; then mkdir ${WORKSPACE}/"build/allure-results"; fi', returnStatus: true)
            sh(script: 'cp ${WORKSPACE}/"src/test/resources/categories.json" ${WORKSPACE}/"build/allure-results"', returnStatus: true)
            script {
                allure([
                        includeProperties: false,
                        jdk              : '/home/usr/lib/jvm/jdk-11.0.1',
                        properties       : [],
                        reportBuildPolicy: 'ALWAYS',
                        results          : [[path: 'build/allure-results']]
                ])
            }
        }
    }
}