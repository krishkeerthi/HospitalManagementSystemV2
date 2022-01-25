package com.krish.hms.ui

import com.krish.hms.helper.getModule
import com.krish.hms.model.Modules

class Activity(val viewModel: ViewModel, val uiHandler: UIHandler) {

    fun launch(){
        uiHandler.welcomeMessage()
        while(true){
            when(getModule(uiHandler.readModules())){
                Modules.ADDDOCTOR -> viewModel.addDoctor()

                Modules.ADDPATIENT -> viewModel.addPatient()

                Modules.HANDLECONSULTATION -> viewModel.handleConsultation()

                Modules.LISTDOCTORS -> viewModel.listDoctors()

                Modules.LISTPATIENTS -> viewModel.listPatients()

                Modules.LISTCASES -> viewModel.listCases()

                Modules.EXIT -> break
            }
        }
        uiHandler.thankYouMessage()
    }
}