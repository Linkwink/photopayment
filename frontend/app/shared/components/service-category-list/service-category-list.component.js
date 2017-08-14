/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appServiceCategoryList', {
            templateUrl: 'app/shared/components/service-category-list/service-category-list.template.html',
            controller: ServiceCategoryListController
        });

    ServiceCategoryListController.$inject = ['$state', 'serviceGroupModel', 'apiPath'];

    function ServiceCategoryListController($state, serviceGroupModel, apiPath) {
        let vm = this;

        vm.model = {
            categories: serviceGroupModel.getAll(),
            api: apiPath.root
        };

        vm.actions = {
            showDetails: showDetails
        };

        function showDetails(serviceCategory) {
            if (serviceCategory.id) {
                $state.go('app.administrator.serviceManager.categoryDetails.layout', { categoryId: serviceCategory.id, serviceCategory: serviceCategory});
            }
        }


    }

})();
