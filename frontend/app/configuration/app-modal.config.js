/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {

    'use strict';

    angular.module("app").config(modalConfig);

    modalConfig.$inject = ['$mdDialogProvider'];

    function modalConfig($mdDialogProvider) {

        const authorizeModalPreset = {
            options: function() {
                return {
                    template : '<md-dialog flex="30"><app-authorize-modal></app-authorize-modal></md-dialog>',
                    clickOutsideToClose: false,
                    escapeToClose: false,
                    preserveScope: true
                }
            }
        };



        $mdDialogProvider.addPreset('authorizeModal', authorizeModalPreset);

    }
})();