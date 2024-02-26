package io.cloud.aws.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// write java class AWSS3Config to configure the AWS S3 client.
// The class should have the following properties:
// accessKey, secretKey, region.
// The class should have a credentials() method that returns an AWSCredentials object.
// The class should have a amazonS3() method that returns an AmazonS3 object.
// The class should be annotated with @Configuration.
// The class should be registered in the Spring application context.


@Configuration
public class AWSS3Config {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${region}")
    private String region;

    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return credentials;
    }

    @Bean
    public AmazonS3 amazonS3() {

        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials())).withRegion(region).build();
        return s3client;
    }
}