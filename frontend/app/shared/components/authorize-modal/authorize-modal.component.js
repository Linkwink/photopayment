/**
 * Created by dn110592kvo on 14.07.2017.
 */
;(function () {

    'use strict';

    angular.module('app')
        .component('appAuthorizeModal', {
            templateUrl: 'app/shared/components/authorize-modal/authorize-modal.template.html',
            controller: AuthorizeModalController
        });

    AuthorizeModalController.$inject = ['authorization'];

    function AuthorizeModalController(authorization) {
        let vm = this;

        vm.menu = {
            loginAsGoogle: authorization.login
        }
    }


})();