/**
 * Created by dn110592kvo on 14.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('welcome', {
            templateUrl: 'app/shared/components/welcome/welcome.template.html',
            controller: WelcomeController,
        });

    WelcomeController.$inject = [];

    function WelcomeController() {
        let vm = this;

    }

})();
