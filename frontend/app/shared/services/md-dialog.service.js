/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {

    'use strict';

    angular.module('app').factory('mdDialog', mdDialog);

    mdDialog.$inject = ['$mdDialog'];

    function mdDialog($mdDialog) {

        function showAuthorizeModal() {
            $mdDialog.show($mdDialog.authorizeModal());
        }

        return {
            showAuthorizeModal: showAuthorizeModal
        };
    }

})();