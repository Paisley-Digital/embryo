package digital.paisley.embryo.services;

import digital.paisley.embryo.clients.DummyClient;
import digital.paisley.embryo.repositories.DummyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

	private final DummyClient dummyClient;

	private final DummyRepository dummyRepository;

	private static Logger log = LoggerFactory.getLogger(DummyService.class);

	public DummyService(DummyClient dummyClient, DummyRepository dummyRepository) {
		this.dummyClient = dummyClient;
		this.dummyRepository = dummyRepository;
	}

	public String getDummyById(Long id) {
		return dummyRepository.getOne(id).getDummy();
	}

	public String getDummyByIdFromClient(Long id) {
		return dummyClient.getById(id);
	}

}
