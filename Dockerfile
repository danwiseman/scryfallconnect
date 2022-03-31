FROM confluentinc/cp-kafka-connect:3.2.0

WORKDIR /kafka-connect-source-scryfall
COPY config config
COPY target target

VOLUME /kafka-connect-source-scryfall/config
VOLUME /kafka-connect-source-scryfall/offsets

CMD CLASSPATH="$(find target/ -type f -name '*.jar'| grep '\-package' | tr '\n' ':')" connect-standalone config/worker.properties config/ScryfallSourceConnecter.properties