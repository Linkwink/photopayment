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

    NewServiceTypeController.$inject = ['$state', 'serviceType', 'auxiliaryField', 'notification'];

    function NewServiceTypeController($state, serviceType, auxiliaryField, notification) {
        let vm = this;

        vm.model = {
            newServiceType: new serviceType(),
            auxiliaryFieldTypes: auxiliaryField.getAll(),
            inProgress: false
        };

        vm.actions = {
            create: create
        };

        function create() {
            vm.model.inProgress = true;
            vm.model.newServiceType.$save()
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
                vm.model.inProgress = false;
                $state.go('app.administrator.serviceManager.layout');
            })
        }
    }

})();
