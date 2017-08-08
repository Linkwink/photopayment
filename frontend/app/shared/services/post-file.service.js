/**
 * Created by dn110592kvo on 08.08.2017.
 */
;(function () {

    'use strict';

    angular.module('app').provider('PostFile', postFile);

    function postFile() {
        return {
            $get: get
        };
    }

    get.$inject = ['$resource'];

    function get($resource) {

        let url = null;

        function setUrl(newUrl) {
            url = newUrl;
        }

        function withFile() {
            if (url) {
                return $resource(url,  { id: "@id" }, {
                    send: {
                        method: "POST",
                        transformRequest: angular.identity,
                        headers: { 'Content-Type': undefined }
                    }
                });
            }
            return null;
        }

        return {
            setUrl: setUrl,
            withFile: withFile
        }

    }

})();