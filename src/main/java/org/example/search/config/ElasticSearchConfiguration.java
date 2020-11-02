/*package org.example.search.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories
@ComponentScan("org.example.search")
//The base class AbstractElasticsearchConfiguration already provides the elasticsearchTemplate bean.
public class ElasticSearchConfiguration {
*/
	/*@Override
	public class RestHighLevelClient elasticsearchClient() {
		return RestClients.create(ClientConfiguration).rest();
	}

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration clientConfiguration
				= ClientConfiguration.builder()
				.connectedTo("localhost:9200")
				.build();

		return RestClients.create(clientConfiguration).rest();
	}
}*/
	/*@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
		return new ElasticsearchTemplate(getClient());
	}

	@Bean
	public Client getClient() throws UnknownHostException { */
		/*Settings setting = Settings
				.builder()
				.put("client.transport.sniff", true)
				.put("path.home", "/usr/share/elasticsearch") //elasticsearch home path
				.put("cluster.name", "elasticsearch")
				.build();
		//please note that client port here is 9300 not 9200!
		Client client = new TransportClient()
				.addTransportAddress(new InetSocketTransportAddress(
						"143.79.236.xxx",
						9300));*/
		/*TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
		return client;
	}*/

	/*@Bean
	public ElasticsearchOperations elasticsearchRestTemplate() {
		return new ElasticsearchRestTemplate(client());
	}
	}*/

	/*@Bean
	RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration configuration = ClientConfiguration.localhost();
		RestHighLevelClient client = RestClients.create(configuration).rest();
		return client;
	}

	@Bean
	ElasticsearchRestTemplate elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(elasticsearchClient());
	}*/

	//private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchConfiguration.class);
	//@Value("localhost:9300")
	//private String clusterNodes;
	//@Value("elasticsearch")
	//private String clusterName;
	//private RestHighLevelClient restHighLevelClient;

	/*public void destroy() {
		try {
			if (client != null) {
				client.close();
			}
		} catch (final Exception e) {
			LOG.error("Error closing ElasticSearch client: ", e);
		}
	}*/

	/*@Override
	public Class<RestHighLevelClient> getObjectType() {
		return RestHighLevelClient.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}*/

	/*@Override
	public RestHighLevelClient createInstance() {
		return buildClient();
	}*/

	/*private RestHighLevelClient buildClient() {
		try {
			restHighLevelClient = new RestHighLevelClient(
					RestClient.builder(
							new HttpHost("localhost", 9200, "http"),
							new HttpHost("localhost", 9201, "http")));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return restHighLevelClient;
	}*/
//}
