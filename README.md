

# Projeto Final - Sistema Distribuidos
## Servidor REST utilizando API REST-RS


1. Consultar veículo por cidade, modelo e faixa de preço

END POINT: localhost:8080/server/api/veiculo/busca1?cidade=Baixo Guandu&modelo=classic&preco_inicial=15000.0&preco_final=50000.0

                
                    
2. Consultar veículo por cidade, faixa de preço, ar condicional e tipo de câmbio

END POINT: localhost:8080/server/api/veiculo/busca2?cidade=Baixo Guandu&preco_inicial=15000.0&preco_final=50000.0&ar_condicionado=true&cambio=manual
 
        
3. Consultar veículo por cidade, faixa de preço, ar condicional, tipo de câmbio e combustível

END POINT: localhost:8080/server/api/veiculo/busca3?cidade=Baixo Guandu&preco_inicial=15000.0&preco_final=50000.0&ar_condicionado=true&cambio=manual&combustivel=gasolina
 
             
4. Cadastrar reserva de veiculo 
                
END POINT: localhost:8080/server/api/reserva
               
Usar o verbo HTTP: <b>POST</b> e no corpo enviar o JSON com dados da reserva.
                
                    {
                    "id": 4,
                    "data_fim": "20/12/2021",
                    "data_inicio": "20/12/2021",
                    "valor": 100.0,    
                    "locadora": {
                    "id": 2,
                    },

                    "veiculo": {
                    "id": 11,
                    },
                    "cidade": {
                    "id": 2,
                    }  

                    }

            

            
5. Alterar reserva de veículo
               
END POINT: localhost:8080/server/api/reserva
                    
Usar o verbo HTTP: <b>PUT</b> e no corpo enviar o JSON com dados que deseja alterar na reserva.
                    
                        {
                        "id": 4,
                        "data_fim": "20/12/2021",
                        "data_inicio": "20/12/2021",
                        "valor": 100.0,    
                        "locadora": {
                        "id": 2,
                        },

                        "veiculo": {
                        "id": 11,
                        },
                        "cidade": {
                        "id": 2,
                        }  

                        }
                        
                   
6. Excluir reserva de veículo 
        
                api/reserva/4
                localhost:8080/server/api/reserva/4
                       
                Usar o verbo HTTP: <b>DELETE</b> enviando o ID no fim do END POINT.
                       
                
                       
