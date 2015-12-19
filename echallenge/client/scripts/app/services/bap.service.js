    'use strict';

app
    .factory('Bap', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/baps/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray : true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/:id'
                      },
            'bapByStatut' :
            {
                     method: 'GET',
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/:statut'
            },
            'bapCourant' :
            {
                     method: 'GET',
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/EN_COURS'
            },
            'valider' : {
                    method : 'POST',
                    isArray:false,
                    url :'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/valider'
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
