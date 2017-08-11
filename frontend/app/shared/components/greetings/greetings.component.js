/**
 * Created by dn110592kvo on 26.07.2017.
 */
;(function () {

    'use strict';

    angular
        .module('app')
        .component('appGreetings', {
            templateUrl: 'app/shared/components/greetings/greetings.template.html',
            controller: GreetingsController,
        });

    GreetingsController.$inject = ['userModel'];

    function GreetingsController(userModel) {
        let vm = this;

        vm.model = {
            user: userModel.getUser()
        }

    }

})();
