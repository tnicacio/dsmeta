# DSMeta
> Projeto da nova [Semana Spring React](https://github.com/devsuperior/sds-dsmeta) da DevSuperior.

## Implantação na nuvem
A aplicação possui o seu frontend publicado em https://dsmeta-tnicacio.netlify.app/

e o seu backend em https://dsmeta-tnicacio.herokuapp.com.

## Rotas da aplicação

### [GET] /sale
* Retorna a página contendo as vendas no seguinte formato:
```
{
    "content": [
        {
            "id": 37,
            "sellerName": "Padme",
            "visited": 82,
            "deals": 82,
            "amount": 22465.0,
            "date": "2022-02-27"
        },
        ...
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 6,
    "totalElements": 111,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 20,
    "empty": false
}
```

### [POST] /sale/{id}/notification
* Realiza o envio do SMS contendo as informações da venda sobre o vendedor de id informado.
O SMS é enviado com auxílio da API da Twilio.


## Tecnologias utilizadas
* Java 17
* SpringBoot
* Typescript
* React 
* Vite 
* API da Twilio
