// /**
//  * Created by dn110592kvo on 21.07.2017.
//  */
// ;(function () {
//
//     'use strict';
//
//     const USER_COOKIE = "c_u";
//
//     angular
//         .module('app')
//         .factory('httpAuth', httpAuth);
//
//     function httpAuth($injector) {
//         return {
//             response: function (config) {
//                 debugger;
//                 // let cookies = $injector.get('$cookies'),
//                 //     authorization = $injector.get('authorization');
//                 // if (cookies.get(USER_COOKIE)) {
//                 //     if (!authorization.isAuthorized()) {
//                 //         authorization.setAuthorized();
//                 //     }
//                 // } else {
//                 //     authorization.setUnauthorized();
//                 // }
//                 return config;
//             }
//         }
//     }
//
// })();