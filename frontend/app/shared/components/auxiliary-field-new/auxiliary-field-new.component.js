/**
 * Created by dn110592kvo on 19.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuxiliaryFieldNew', {
            templateUrl: 'app/shared/components/auxiliary-field-new/auxiliary-field-new.template.html',
            controller: AuxiliaryFieldNewController
        });

    AuxiliaryFieldNewController.$inject = ['$state','auxiliaryField', 'notification'];

    function AuxiliaryFieldNewController($state, auxiliaryField, notification) {
        let vm = this;

        vm.model = {
            auxiliaryField: new auxiliaryField(),
            fieldTypes: auxiliaryField.getFieldTypes(),
            inProgress: false
        };

        vm.actions = {
            create: create
        };

        function create() {
            vm.model.inProgress = true;
            vm.model.auxiliaryField.id = null;
            vm.model.auxiliaryField.$save()
                .then(
                    sucess => {
                        notification.show('Поле создано успешно!');
                        return null;
                    },
                    error => {
                        notification.show('Возникла ошибка при создании поля!');
                        return null;
                    }
                ).then((resp) => {

                $state.go('app.administrator.auxFields');
                vm.model.inProgress = false;
            })
        }

    }

})();