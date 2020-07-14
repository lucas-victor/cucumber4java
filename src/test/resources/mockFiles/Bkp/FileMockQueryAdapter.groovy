package net.oi.sis.network.adapter

import net.oi.sis.common.logging.SisLogger
import net.oi.sis.domain.common.GenericRepository
import net.oi.sis.domain.common.RepositoryFactory
import net.oi.sis.domain.impl.GenericRepositoryJpa
import net.oi.sis.domain.common.MockReplyConfig
import net.oi.sis.domain.impl.MockReplyConfigImpl
import net.oi.sis.domain.inventory.NetworkElement
import net.oi.sis.domain.network.ServiceCommand

class FileMockQueryAdapter extends MockAdapter {

	private final static SisLogger log = SisLogger.getLogger(FileMockQueryAdapter.class);

	private GenericRepositoryJpa repository;
	private List<MockReplyConfig> replies;
	private String reply;

	@Override
	public String service(ServiceCommand command) {
		if(isCommandExistsInMapping(command)) {
			return reply;
		} else {
			return super.service(command);
		}
	}

	private boolean isCommandExistsInMapping(ServiceCommand command) {
		replies = getRepliesFromTechnology(command);
		String reply = getReplyFromCommand(replies, command);		
		return reply != null;
	}
	
	private String getReplyFromCommand(List<MockReplyConfig> replies, ServiceCommand command) {
		String syntaxCommand = command.getCommand().getSyntax();
		for(MockReplyConfig replyMock : replies) {
			if(syntaxCommand.contains(replyMock.getSyntaxCommand())) {
				reply = replyMock.getReply();
				
				def file = new File(reply);
				if(file.exists()) {
					reply = file.text;
					if(reply.lastIndexOf('\n') != -1) {
						reply = reply.substring(0, reply.lastIndexOf('\n'));
					}
				}
				
				return reply;
			}
		}
		return null;
	}

	private List<MockReplyConfig> getRepliesFromTechnology(ServiceCommand command) {
		repository = (GenericRepositoryJpa) RepositoryFactory.getFactory().createGenericRepository();
		return repository.entityManager.createQuery("select mock from MockReplyConfigImpl mock where mock.technology like :technology", MockReplyConfigImpl.class)
					.setParameter("technology", command.getCommand().getTechnology().getManufacturer())
					.getResultList();
	}

	@Override
	public void init(String connectionPortId, NetworkElement ne) throws AdapterInitializationException {
		super.init(connectionPortId, ne);
	}
}
