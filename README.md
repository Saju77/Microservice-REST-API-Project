# Microservice-REST-API-Project
=> Some initial steps to run the project : 
  1. Create a database schema(name: ctrends_evidence) in postgreSQL if you want to use postgreSQL database and tables will create automatically.
    Note: Comment out the 'PostgreSQL Driver' and uncomment the 'H2 Database' if you want to use 'H2 Database'.
  2. Run the services step by step : -> I. discovery-server(port:8761) -> II. config-server(port:9296) -> III. employee-service(port:9001) -> IV. team-service(port:9002)
                                     -> V. member-service(port:9003) -> VI. api-cloud-gateway(port:9191)
  3. Run those insert query to make available some role data first -> INSERT INTO roles(name) VALUES('ROLE_USER'); INSERT INTO roles(name) VALUES('ROLE_ADMIN');

=> Some helpful insertion process(according to the project flow) : 
  1. Insert demo for employee-service -> I. To SignUp new Employee : (in postman with jason format)
                                              {
                                                  "empname": "MUHAMMAD MARUF HASAN",
                                                  "username": "mmhasan",
                                                  "email": "mmhasan@gmail.com",
                                                  "password": "mmhasan",
                                                  "designation": "Acting Team Leader, UX Design",
                                                  "mobileno": "01*********",
                                                  "address": "address of M. M. Hasan",
                                                  "role": ["user","admin"]
                                              }
                                        II. To SignIn Employee account :
                                              {
                                                  "username": "mmhasan",
                                                  "password": "mmhasan"
                                              }
                                              
  2. Insert demo for team-service -> To create new Team : (in postman with jason format)
                                        {
                                            "tmName": "Software Architect Team",
                                            "tmDetails": "Details about Software Architect Team",
                                            "tmActivities": "Activity details about Software Architect Team",
                                            "tmLeader": "MUHAMMAD MARUF HASAN",
                                            "totMember": 5
                                        }
  3. Insert demo for member-service -> To save new Member : (in postman with jason format)
                                          {
                                              "mName": "MUHAMMAD MARUF HASAN",
                                              "designation": "Details about Software Architect Team",
                                              "mobileNo": "Activity details about Software Architect Team",
                                              "email": "MUHAMMAD MARUF HASAN",
                                              "tmId": 1 // This tmId(Team id) should be from team table.
                                          }
