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

    NewServiceCategoryController.$inject = ['$state', 'serviceGroup', 'notification'];

    function NewServiceCategoryController($state, serviceGroup, notification) {
        let vm = this;

        vm.model = {
            newCategory: new serviceGroup(),
            file: null,
            inProgress: false
        };

        vm.actions = {
            create: create
        };

        function create() {
            vm.model.inProgress = true;
            vm.model.newCategory.$save()
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
