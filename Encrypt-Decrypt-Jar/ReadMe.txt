Open a terminal window in this directory.

------------------------------------------------------------------------------------------

Use the following syntax to encrypt or decrypt a text string provided as a parameter:

java -jar secure-properties-tool.jar string encrypt/decrypt <algorithm> <mode> <key> <value>

java -jar secure-properties-tool.jar string encrypt Blowfish CBC mulesoft password
Qzz+/L86Az7HzUz+4uszzw==

Replace the value in the yaml file by:
keystore:
  basePath: "keystore/keystore.jks"
  password: "![Qzz+/L86Az7HzUz+4uszzw==]"
  
------------------------------------------------------------------------------------------

Use the following syntax to encrypt or decrypt a file provided as a parameter:

java -jar secure-properties-tool.jar file encrypt/decrypt <algorithm> <mode> <key> <inputfilepath> <outputfilepath>



