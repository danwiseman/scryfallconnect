FROM confluentinc/cp-kafka-connect:3.2.0

WORKDIR /scryfallconnect
COPY config config
COPY target target

VOLUME /scryfallconnect/config
VOLUME /scryfallconnect/offsets

CMD CLASSPATH="$(find target/ -type f -name '*.jar'| grep '\-package' | tr '\n' ':')" connect-standalone config/worker.properties config/ScryfallSourceConnecter.properties