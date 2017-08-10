/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appServiceCategoryList", {
            templateUrl: "app/shared/components/service-category-list/service-category-list.template.html",
            controller: ServiceCategoryListController
        });

    ServiceCategoryListController.$inject = ['serviceGroupModel', 'apiPath'];

    function ServiceCategoryListController(serviceGroupModel, apiPath) {
        let vm = this;

        vm.model = {
            categories: serviceGroupModel.getAll(),
            api: apiPath.root
        };


    }

})();
