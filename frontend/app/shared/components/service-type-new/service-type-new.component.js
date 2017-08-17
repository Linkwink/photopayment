/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appNewServiceType', {
            templateUrl: 'app/shared/components/service-type-new/service-type-new.template.html',
            controller: NewServiceTypeController
        });

    NewServiceTypeController.$inject = ['$state', 'serviceTypeModel', 'auxiliaryFieldTypeModel', 'notification'];

    function NewServiceTypeController($state, serviceTypeModel, auxiliaryFieldTypeModel, notification) {
        let vm = this;

        vm.model = {
            newServiceType: serviceTypeModel.create(),
            auxiliaryFieldTypes: auxiliaryFieldTypeModel.getAll(),
            file: null,
            inProgress: false
        };

        vm.actions = {
            create: create
        };

        function create() {
            vm.model.inProgress = true;
            let file = vm.model.file.shift();
            if (file) {
                file = file.lfFile;
            }
            serviceGroupModel.save(vm.model.newCategory, file)
                .then(
                    sucess => {
                        notification.show('Категория создана успешно!');
                        return null;
                    },
                    error => {
                        notification.show('Возникла ошибка при создании категории!');
                        return null;
                    }
                ).then(() => {
                $state.go('app.administrator.serviceManager.layout');
                vm.model.inProgress = false;
            })
        }
    }

})();
