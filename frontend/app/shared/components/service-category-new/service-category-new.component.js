/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    'use strict'

    angular
        .module('app')
        .component('appNewServiceCategory', {
            templateUrl: 'app/shared/components/service-category-new/service-category-new.template.html',
            controller: NewServiceCategoryController
        });

    NewServiceCategoryController.$inject = ['$state', 'serviceGroupModel', 'notification'];

    function NewServiceCategoryController($state, serviceGroupModel, notification) {
        let vm = this;

        vm.model = {
            newCategory: serviceGroupModel.create(),
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
