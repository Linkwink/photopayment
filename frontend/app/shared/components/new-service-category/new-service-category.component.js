/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appNewServiceCategory", {
            templateUrl: "app/shared/components/new-service-category/new-service-category.template.html",
            controller: NewServiceCategoryController
        });

    NewServiceCategoryController.$inject = ['serviceGroupModel'];

    function NewServiceCategoryController(serviceGroupModel) {
        let vm = this;

        vm.model = {
            newCategory : serviceGroupModel.create(),
            file: null
        };

        vm.actions = {
            create: create
        };

        function create() {
            let file = vm.model.file.shift();
            if (file) {
                file = file.lfFile;
            }
            serviceGroupModel.save(vm.model.newCategory, file);
        }
    }

})();
