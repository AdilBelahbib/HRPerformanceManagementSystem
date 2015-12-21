    'use strict';

    app
    .factory('DemandeBip', function ($resource, $filter) {

        return $resource('/HRPerformanceManagementSystem/resources/demandebips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                method: 'GET',
                isArray : true,
                url: '/HRPerformanceManagementSystem/resources/demandebips/collaborateur/:id'
            },
            'manager' : { 
                method: 'GET',
                isArray : true,
                url: '/HRPerformanceManagementSystem/resources/demandebips/manager/:id'
            },
            'encadrant' :
            {
               method: 'GET',
               url: '/HRPerformanceManagementSystem/resources/demandebips/encadrant/:id'
           },
           'update': { method:'PUT' },
           'save': { method:'POST' }
       });
    });
