'use strict';

app
    .factory('Profil', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/profils/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'code':
                    {  
                        method:'GET',
                        url:'/HRPerformanceManagementSystem/resources/profils/bycode/:code'

                    },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
