/**
 * Created by dn110592kvo on 14.07.2017.
 */
;(function () {

    'use strict';

    const USER_COOKIE = 'c_u';

    angular.module('app').provider('authorization', authorization);

    function authorization() {
        return {
            $get: get
        };
    }

    get.$inject = ['$http', '$window', 'apiPath', 'userModel', 'http_sc'];

    function get($http, $window, apiPath, userModel, http_sc) {

        function login() {
            return $window.location.href = `${apiPath.root}/auth/login`
        }

        function isAuthorized() {
            return $http.get(`${apiPath.root}/auth/me`)
                .then(authorizationSuccess)
                .catch(authorizationFailed);

            function authorizationSuccess(data) {
                let response = data.data;
                if (response.code === http_sc.unauthorized) {
                    return false;
                } else {
                    userModel.setUser(response);
                    return true;
                }
            }

            function authorizationFailed() {
                return false;
            }
        }



        function hasPermission(pathToView) {
            let user = userModel.getUser();
            if (user) {
            } else {
                return false;
            }
        }

        return {
            login: login,
            isAuthorized: isAuthorized,
            hasPermission: hasPermission
        }
    }


})();