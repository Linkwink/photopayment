/**
 * Created by dn110592kvo on 21.07.2017.
 */
;(function () {
    'use strict';

    angular.module('app').factory('userModel', userModel);


    function userModel() {

        let user = {
            id: null,
            ldap: null,
            name : null,
            picture: null,
            roles : null,
            email: null,
            branch : null
        };

        function setUser({ id, ldap, email, name, picture, roles, branch}) {
                user.id = id;
                user.ldap = ldap;
                user.email = email;
                user.name  = name;
                user.picture = picture;
                user.roles  = roles;
                user.branch = branch
        }

        function getUser() {
        console.log(true);
            return user;
        }

        return {
            getUser: getUser,
            setUser: setUser
        }
    }

})();