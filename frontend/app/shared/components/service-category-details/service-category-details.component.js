/**
 * Created by dn110592kvo on 11.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appServiceCategoryDetails', {
            templateUrl: 'app/shared/components/service-category-details/service-category-details.template.html',
            controller: ServiceCategoryDetailsController
        });

    ServiceCategoryDetailsController.$inject = ['$stateParams', 'serviceGroupModel'];

    function ServiceCategoryDetailsController($stateParams, serviceGroupModel) {
        let vm = this;

        vm.model = {
            serviceCategory: $stateParams.serviceCategory || serviceGroupModel.get($stateParams.categoryId)
        };



    }

})();
