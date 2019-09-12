# Hotels

## Approccio al problema
Non avendo moltissimo tempo a disposizione per lo svolgimento ho dato priorità all'implementazione
delle funzionalità richieste trascurando inizialmente la parte di testing. So che non è una buona abitudine ma
implementando il pattern MVP pensavo di riuscire a sopperire in seguito: non ci sono riuscito in modo sufficiente.
Mi sono anche preso il rischio di migrare ad androidx con il progetto in corso, ho avuto solo qualche
difficoltà con i test di espresso su intent e recyclerview che poi ho abbandonato, sempre per questioni di tempo.
Un altro azzardo è stato l'utilizzo di RxJava, di cui non mi sento molto esperto ma per una semplice chiamata non
mi ha causato particolari problemi, nemmeno nei test.
Il sorting sul numero di stelle è un po'banale. Essendo un "nice to have" mi sono permesso di scegliere la cosa più facile,
anche in questo caso riservandomi di migliorare/arricchire qualora fosse rimasto tempo.

## Cosa non va
* la UI credo sia abbastanza completa ma è da abbellire
  * quella del dettglio in particolare
* serve presenter per dettaglio per action varie:
  * chiamata telefonica
  * vedi mappa
  * invia email
  * ...
* manca una progressbar per il caricamento
* il FAB per fare toggle del sorting non è molto bello
  * e.g: meglio aprire un activityForResult in cui impostare diverse opzioni
* le stringhe, le dimensioni... non sono estratte in risorse
* alcune parti di codice dovrebbero essere rifattorizzate
* la libreria Picasso potrebbe essere isolata dentro un nostro oggetto
* i test sono solo abbozzati
* non ho usato una libreria di mock
* seppure siano gestiti, i casi di errore e le corrispondenti azioni utente potrebbero essere migliorate

Ho indicato tramite dei TODO direttamente nel codice le cose che credo siano migliorabili e alcuni test che ritengo necessari.

