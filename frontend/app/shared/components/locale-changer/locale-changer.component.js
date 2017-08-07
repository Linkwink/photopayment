/**
 * Created by dn110592kvo on 07.08.2017.
 */
;(function () {

    "use strict";

    angular
        .module("app")
        .component("appLocaleChanger", {
            templateUrl: "app/shared/components/locale-changer/locale-changer.template.html",
            controller: LocaleChangerController,
        });

    LocaleChangerController.$inject = ['userModel'];

    function LocaleChangerController(userModel) {
        let vm = this;

        vm.model = {
            currentLanguage: "UA"
        }

    }

})();
