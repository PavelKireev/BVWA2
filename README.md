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

Then fill the required info using the matching key pass option as the password 

## Windows
"C:\Program Files\Java\jdk1.6.0_26\bin\keytool.exe" + same options as above
