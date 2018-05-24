package google.tts.api.googlettsapi;

import com.google.cloud.texttospeech.v1beta1.*;
import com.google.protobuf.ByteString;
import org.springframework.util.Base64Utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SynthesizeText {
    /**
     * Demonstrates using the Text to Speech client to synthesize text or ssml.
     * @param text the raw text to be synthesized. (e.g., "Hello there!")
     * @throws Exception on TextToSpeechClient Errors.
     */
    public static String synthesizeText(String text,String lang)
            throws Exception {
        // Instantiates a client
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            // Set the text input to be synthesized
            SynthesisInput input = SynthesisInput.newBuilder()
                    .setText(text)
                    .build();
            // Build the voice request
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode(lang) // languageCode = "en_us"
                    .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
                    .build();

            // Select the type of audio file you want returned
            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
                    .build();

            // Perform the text-to-speech request
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice,
                    audioConfig);
            ByteString audioContents = response.getAudioContent();
            return new String(Base64Utils.encode(audioContents.toByteArray()));
        }
    }
}
