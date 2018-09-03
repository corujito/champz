if [ "$MONGO_USERNAME" ] && [ "$MONGO_PASSWORD" ]; then
  ${mongo[@]} $MONGO_INITDB_DATABASE --eval "db.createUser({ user: '$MONGO_USERNAME', pwd: '$MONGO_PASSWORD', roles: [ 'readWrite', 'dbAdmin' ] })"
  ${mongo[@]} champz-it-db --eval "db.createUser({ user: 'champz-it', pwd: '123456', roles: [ 'readWrite', 'dbAdmin' ] })"
fi

rm -rf seed-data.sh
