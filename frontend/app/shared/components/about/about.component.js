/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appAbout', {
            templateUrl: 'app/shared/components/about/about.template.html',
            controller: AppAboutController,
        });

    AppAboutController.$inject = [];

    function AppAboutController() {
        let vm = this;
    }

})();