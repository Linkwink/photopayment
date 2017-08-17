/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appAdminLayout', {
            templateUrl: 'app/interfaces/admin/components/layout/admin-layout.template.html',
            controller: AdminLayoutController,
        });

    AdminLayoutController.$inject = [];

    function AdminLayoutController() {
        let vm = this;

        const ADMIN_MENU = [
            { order: 0, title: 'Главная', href: 'app.administrator.layout', icon: 'home'},
            { order: 1, title: 'Настройка индикатива', href: 'app.administrator.indicativeSettings', icon: 'attach_money'},
            { order: 2, title: 'Управление заявками', href: 'app.administrator.taskManager', icon: 'assignment'},
            { order: 3, title: 'Управление пользователями', href: 'app.administrator.userManager', icon: 'people'},
            { order: 4, title: 'Настройка полей заявки', href: 'app.administrator.auxFields', icon: 'subject'},
            { order: 5, title: 'Настройка типов услуг', href: 'app.administrator.serviceManager', icon: 'build'}
        ];


        vm.menu = {
            menu: ADMIN_MENU
        }

    }

})();
