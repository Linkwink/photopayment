/**
 * Created by Viacheslav_Khromoi on 12.08.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appServiceCategoryOne', {
            templateUrl: 'app/shared/components/service-category-one/service-category-one.template.html',
            controller: ServiceCategoryOneController,
            bindings: {
                serviceCategory: '<'
            }
        });

    ServiceCategoryOneController.$inject = ['apiPath'];

    function ServiceCategoryOneController(apiPath) {
        let vm = this;

        vm.model = {
            path: apiPath.root
        };
    }

})();