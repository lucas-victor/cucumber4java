INSERT INTO "sis"."tbmockreplyconfig" (ID_REPLY,ST_COMMAND,ST_REPLY,NO_TECNOLOGIA) VALUES 
(5,'<bcc:CustomerKey>','/appl-sis-2/sis/bitelas/subscribers_CPF','OCS Huawei')
,(20,'<QueryCustomerInfoRequest>','/appl-sis-2/sis/bitelas/subscribers_ID','OCS Huawei')
,(14,'<?xml version','%<StatusCode>0</StatusCode>%','IN OFERTA')
,(17,'<?xml version','%<StatusCode>0</StatusCode>%','IN ATIVACAO')
,(21,'SHOW','{  

   "externalId":"12345",

   "timeToLive":60000,

   "priority":5,

   "systemId":"Consulta Plataformas GSM",

   "serviceElements":[  

      {  

         "code":"ConsultarAssinanteDestBarrVmp",

         "parameters":[  

            {  

               "NECODE":"SMS03"

            },

            {  

               "MSISDN":"553198814562"

            }

         ],

         "response":{  

            "type":"Success",

            "details":[  

               {  

                  "networkElement":"SMS03",

                  "executionTimestamp":"2019-06-11T10:37:52.342Z",

                  "description":"Executado com sucesso",

                  "searchParameters":[  

                     {  

                         "SMSC_INF_BASIC_PLANO":"PRE-PAGO"

                      },

                      {  

                         "SMSC_INF_BASIC_CUSTOMER_ID":""

                      },

                      {

                         "SMSC_INF_BASIC_OCOS_TCOS_RCOS": ""

                      },

                      {

                         "SMSC_INF_BASIC_APROVISIONADO": "false"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_TORPEDO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_TORPEDO": "true"

                      }

                      ,

                      {

                         "SMSC_INF_BASIC_RECEPCAO_TORPEDO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_MSG_RECEPCAO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_MSG_RECEPCAO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_RECEPCAO_MSG_RECEPCAO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_SOM_RECEPCAO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_SOM_RECEPCAO": "true"

                      },

                       {

                         "SMSC_INF_BASIC_RECEPCAO_SOM_RECEPCAO": "true"

                      }

                  ]

               }

            ]

         }

      }

   ]

}','SMSC Acision')
,(22,'SH SUBSCRIBER','{  

   "externalId":"12345",

   "timeToLive":60000,

   "priority":5,

   "systemId":"Consulta Plataformas GSM",

   "serviceElements":[  

      {  

         "code":"ConsultarAssinanteDestBarrVmp",

         "parameters":[  

            {  

               "NECODE":"SMS03"

            },

            {  

               "MSISDN":"553198814562"

            }

         ],

         "response":{  

            "type":"Success",

            "details":[  

               {  

                  "networkElement":"SMS03",

                  "executionTimestamp":"2019-06-11T10:37:52.342Z",

                  "description":"Executado com sucesso",

                  "searchParameters":[  

                     {  

                         "SMSC_INF_BASIC_PLANO":"PRE-PAGO"

                      },

                      {  

                         "SMSC_INF_BASIC_CUSTOMER_ID":""

                      },

                      {

                         "SMSC_INF_BASIC_OCOS_TCOS_RCOS": ""

                      },

                      {

                         "SMSC_INF_BASIC_APROVISIONADO": "false"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_TORPEDO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_TORPEDO": "true"

                      }

                      ,

                      {

                         "SMSC_INF_BASIC_RECEPCAO_TORPEDO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_MSG_RECEPCAO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_MSG_RECEPCAO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_RECEPCAO_MSG_RECEPCAO": "true"

                      },

                      {

                         "SMSC_INF_BASIC_STATUS_SOM_RECEPCAO": "Ativo"

                      },

                      {

                         "SMSC_INF_BASIC_ENVIO_SOM_RECEPCAO": "true"

                      },

                       {

                         "SMSC_INF_BASIC_RECEPCAO_SOM_RECEPCAO": "true"

                      }

                  ]

               }

            ]

         }

      }

   ]

}','SMSC Acision')
,(23,'action=consultarAssinante','<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<soap:Body>
		<consultarAssinanteResponse xmlns="http://Server/Aprovisionamento">
			<consultarAssinanteResult>
				<resultCode>0</resultCode>
				<resultText> </resultText>
				<msisdn>5531985974534</msisdn>
				<perfil>1</perfil>
				<codPacote>55619</codPacote>
				<servico>
					<string>1</string>
					<string>2</string>
				</servico>
			</consultarAssinanteResult>
    </consultarAssinanteResponse>
  </soap:Body>
</soap:Envelope>','VMS Novitech')
,(15,'ChangeSubInfoRequest','%<ResultHeader>%ResultCode>118030955</%ResultCode>%</ResultHeader>%','OCS Huawei')
,(16,'ChangeSubLifeCycleRequest','%<ResultHeader>%ResultCode>118030955</%ResultCode>%</ResultHeader>%','OCS Huawei')
,(9,'<spml:','RESP:21','PMS_AJUSTE')
;
INSERT INTO "sis"."tbmockreplyconfig" (ID_REPLY,ST_COMMAND,ST_REPLY,NO_TECNOLOGIA) VALUES 
(10,'spml:modifyRequest','%result="success"%','UDR Nokia')
,(1,'<q0:SubsQuery>','<?xml version="1.0" encoding="utf-16"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <ns1:SubsQueryResp xmlns:ns1="http://oi.com.br/cvas/ivr/SubsQuery/schemas/SubsQuery/v1_0">
            <SubscriberID>5521996811711</SubscriberID>
            <StatusCode>0</StatusCode>
            <BeneftProgramID>4461</BeneftProgramID>
            <OfferName>44.61_Controle_Inter_ALL_Pais17</OfferName>
            <SubsStatus>Active</SubsStatus>
            <SubsPricePlan>OiControleSF</SubsPricePlan>
            <COS>26</COS>
            <PendingFee />
            <SglTopUpRecord>0;0;5438;5438</SglTopUpRecord>
            <CSFTopUpRecord>5438;5438</CSFTopUpRecord>
            <PendingOffer />
			<LastTopUp>22032020</LastTopUp>
			<SubsActDate>20200331</SubsActDate>
			<ChoiceSVA>opt-in</ChoiceSVA>
            <AllBuckets>1;20151213;20200430;500.00|3;20151213;20200601;400.00|5;20171022;20200602;30.00|13;20160427;20200603;1760239.00|15;20170623;20200604;50.00|21;20200322;20200605;2710741.00|22;19800229;20200606;10000.00|25;20171022;20200607;3600.00|26;20191022;20200608;9185.00|19;20171022;20200609;188.00|</AllBuckets>
            <AutoLoan>false</AutoLoan>
            <FCORchgMin>false</FCORchgMin>
            <FCORchgInfo />
            <FCORemainMin />
            <FCODailyFee />
            <RecFeeDate />
            <RecFeeValue />
            <WiFiStatus>1</WiFiStatus>
            <PlanId />
            <PlanType />
            <IncentFlag />
            <CurrThresh />
            <CycleEndDate />
            <CycleEndDay />
            <ThreshActn />
            <ProvThreshold />
            <UsageCount />
            <UsageAccum />
            <CurrBalance />
            <BdlThresh />
            <BdlThreshDate />
            <BdlUsage />
            <TypeUsgMsg>21;77|25;77|</TypeUsgMsg>
            <NextProvThresh />
            <TransferBalance />
        </ns1:SubsQueryResp>
    </soapenv:Body>
</soapenv:Envelope>','IN_BOLSO')
,(2,'<spml:searchRequest','<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Body>
        <spml:searchResponse executionTime="137" requestID="-7add4b95:16b23f414a3:23ed" result="success" searchStatus="completeResult" xmlns:spml="urn:siemens:names:prov:gw:SPML:2:0" xmlns:subscriber="urn:siemens:names:prov:gw:SUBSCRIBER:1:0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
            <version>SUBSCRIBER_v10</version>
            <objects xmlns:ns2="urn:siemens:names:prov:gw:SUBSCRIBER:1:0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="ns2:Subscriber">
                <identifier>fd58eab8-3f72-47e4-b3e3-e8e59818</identifier>
            </objects>
        </spml:searchResponse>
    </soapenv:Body>
</soapenv:Envelope>','UDR Nokia')
,(3,'<ChangeSubOfferingRequest>','%<ResultHeader>%ResultCode>0</%ResultCode>%</ResultHeader>%','OCS Huawei')
,(4,'<rm:getSubscriberAllInf>','%<resultCode>12302</resultCode>%','PCRF Huawei')
,(11,'<bcs:CreateSubscriberRequestMsg>','%<ResultHeader>%ResultCode>0</%ResultCode>%</ResultHeader>%','OCS Huawei')
,(13,'<bcs:SubDeactivationRequestMsg>','%<ResultHeader>%ResultCode>118030955</%ResultCode>%</ResultHeader>%','OCS Huawei')
,(6,'action=Modify','<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Body>
        <modifyResponse xmlns="uri://alcatel.com/apc/9.1" />
    </soapenv:Body>
</soapenv:Envelope>','SMP Nokia')
,(7,'21933330020','Mock_Sucesso','BDODB')
,(12,'CustDeactivationRequestMsg','%<ResultHeader>%ResultCode>118030955</%ResultCode>%</ResultHeader>%','OCS Huawei')
;
INSERT INTO "sis"."tbmockreplyconfig" (ID_REPLY,ST_COMMAND,ST_REPLY,NO_TECNOLOGIA) VALUES 
(24,'LST_USR','<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<soapenv:Body>
		<spml:searchResponse executionTime="14" requestID="43bd8fad:16c6728d035:-7df6" result="success" searchStatus="completeResult" xmlns:spml="urn:siemens:names:prov:gw:SPML:2:0" xmlns:subscriber="urn:siemens:names:prov:gw:SUBSCRIBER:1:0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			<version>SUBSCRIBER_v10</version>
			<objects xmlns:ns2="urn:siemens:names:prov:gw:SUBSCRIBER:1:0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="ns2:Subscriber">
				<Number>31983606850</Number>
				<IMSI>724456789012345</IMSI>
				<NumberType>001</NumberType>
				<HLRAddress>550310006000</HLRAddress>
            </objects>
        </spml:searchResponse>
    </soapenv:Body>
</soapenv:Envelope>
%ResultCode>0<%','SmartKey Huawei')
,(8,'<v1:SubsRecurQuery>','<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <prfx1:SubsRecurQueryResp xmlns:prfx1="http://oi.com.br/cvas/oi/SubsRecurQuery/schemas/SubsRecurQuery/v1_0">
            <Subscriber>5543984355963</Subscriber>
            <StatusCode>0</StatusCode>
            <RecData>Internet - Mensal;01/04/2020;Pendente;2499;--;1024;4101;12/02/2020;ShortCode</RecData>
            <RecVoice>Pct Recorrente Mensal de voz 40 Reais;01/01/2020;Pendente;199;14/04/2020;4000;3210;14/01/2020;ShortCode</RecVoice>
            <RecSms1>Pacote 100 SMS Oi para todas operadoras;30/05/2020;Pendente;800;29/05/2020;100;66300;14/02/2020;ShortCode</RecSms1>
            <RecSms2>Pacote de Teste;07/05/2020;Pendente;800;2020/03/31;100;3260;14/02/2020;ShortCode</RecSms2>
        </prfx1:SubsRecurQueryResp>
    </soapenv:Body>
</soapenv:Envelope>','IN CONSULTA OFERTA')
,(25,'action=Query','<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/" xmlns:abs="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/RpSvcAbs" xmlns:cst="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/CST" xmlns:disco="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/disco" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:dst="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/dst" xmlns:dstdt="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/dst-dt" xmlns:is="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/is" xmlns:lsoap="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/soapbin" xmlns:meta="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/metadata" xmlns:rps="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/RpSvcSch" xmlns:util="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/utility" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:xenc="http://www.w3.org/2001/04/xmlenc#" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<SOAP-ENV:Header>
		<cst:RAFInstance xsi:type="cst:RAFInstanceType" SOAP-ENV:mustUnderstand="1">
			<cst:RAFSelectionInfo xsi:type="cst:RAFSelectionInfoType">
				<cst:TopologyEntity backup="false">
					<cst:Switch/>
					<cst:RAFInstanceID/>
					<cst:ProcessingUnit/>
				</cst:TopologyEntity>
			</cst:RAFSelectionInfo>
		</cst:RAFInstance>
		<Correlation xmlns="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/soapbin" xsi:type="lsoap:CorrelationType" SOAP-ENV:mustUnderstand="1" refToMessageID="666" messageID="2787591574681160.01574111586" timestamp="1969-12-31T23:59:59Z"/>
		<Provider xmlns="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/soapbin" xsi:type="lsoap:ProviderType" SOAP-ENV:mustUnderstand="1" affiliationID="" providerID="Alcatel" id=""/>
		<Timeout xmlns="http://www.alcatel-lucent.com/wsp/ns/2007/03/01/8CH-10385-AAAA/soapbin" xsi:type="lsoap:TimeoutType" SOAP-ENV:mustUnderstand="1"/>
		<wsse:Security xsi:type="wsse:SecurityHeaderType" SOAP-ENV:mustUnderstand="1"/>
	</SOAP-ENV:Header>
	<SOAP-ENV:Body>
		<dst:QueryResponse xsi:type="dst:QueryResponseType" itemIDRef="queryIMS" id="1">
			<util:Status xsi:type="util:StatusType" comment="Overall Status" code="OK" ref="queryIMS">
				<util:Status xsi:type="util:StatusType" comment="AGCFUserServiceProfile Queried " code="OK" ref=""/>
			</util:Status>
			<dst:Data xsi:type="dst:QueryResponseDataType" nextOffset="0" itemIDRef="" id="queryIMS">
				<C_AGCFUserServiceProfile>
					<MainIMPU>tel:+554332510115</MainIMPU>
					<GatewayReference>GO-APX-MUT-1</GatewayReference>
					<EndPointReference>AL54611</EndPointReference>
					<ApplicationCapabilities>
						<Acronym>HFE</Acronym>
						<Attributes>
							<AppAttribute>
								<Name>Activation</Name>
								<Value>false</Value>
							</AppAttribute>
						</Attributes>
					</ApplicationCapabilities>
					<ApplicationCapabilities>
						<Acronym>SpecialDialTone</Acronym>
						<Attributes>
							<AppAttribute>
								<Name>Activation</Name>
								<Value>false</Value>
							</AppAttribute>
						</Attributes>
					</ApplicationCapabilities>
					<ApplicationCapabilities>
						<Acronym>CT</Acronym>
						<Attributes>
							<AppAttribute>
								<Name>Subscription</Name>
								<Value>false</Value>
							</AppAttribute>
						</Attributes>
					</ApplicationCapabilities>
					<ApplicationCapabilities>
						<Acronym>FDC</Acronym>
						<Attributes>
							<AppAttribute>
								<Name>Activation</Name>
								<Value>disabled</Value>
							</AppAttribute>
						</Attributes>
					</ApplicationCapabilities>
					<ApplicationCapabilities>
						<Acronym>FLASHHOOKMODE</Acronym>
						<Attributes>
							<AppAttribute>
								<Name>Subscription</Name>
								<Value>true</Value>
							</AppAttribute>
						</Attributes>
					</ApplicationCapabilities>
					<PriorityLevel>NORMAL</PriorityLevel>
					<RegistrationMode>
						<D_IMSRegIndiv>
							<IMPI>+554332510115@fns.ngnf.brt.net.br</IMPI>
							<IMPU>sip:+554332510115@fns.ngnf.brt.net.br;user=phone</IMPU>
							<LocationforRegistration/>
							<Enabled>true</Enabled>
							<Password>32510115</Password>
						</D_IMSRegIndiv>
					</RegistrationMode>
					<CPC>1</CPC>
				</C_AGCFUserServiceProfile>
			</dst:Data>
		</dst:QueryResponse>
	</SOAP-ENV:Body>
</SOAP-ENV:Envelope>','NGN')
;