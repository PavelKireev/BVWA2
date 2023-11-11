# JWT Keystore generation

To generate your local keystore you must create directory "local" in resources,
go there and call java keytool with the following command in terminal:

```
/your/path/to/java/current/bin/keytool -genkeypair \
  -alias bvwa2-oauth-jwt \
  -keyalg RSA \
  -keypass bvwa2-pass \
  -keystore bvwa2-jwt.jks 
```

Then fill the required info and matching keypass option password
