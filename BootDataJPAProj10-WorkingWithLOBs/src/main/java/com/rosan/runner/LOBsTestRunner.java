package com.rosan.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rosan.entity.MarriageSeeker;
import com.rosan.service.IMatrimonyServiceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner {
	@Autowired
	IMatrimonyServiceMgmt service;

	@Override
	public void run(String... args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter person name");
//		String name = sc.next();
//		System.out.println("Enter person address");
//		String address = sc.next();
//		System.out.println("Enter Person Photo file complete path");
//		String photoPath = sc.next();
//		System.out.println("Enter person biodata file complete path");
//		String biodataPath = sc.next();
//		System.out.println("Is the Person Indian ?");
//		boolean indian = sc.nextBoolean();
//
//		// prepare byte[] representing photo file content
//		InputStream is = new FileInputStream(photoPath);
//		byte[] photoData = new byte[is.available()];
//		photoData = is.readAllBytes();
//
//		// prepare char[] representing biodata file content
//		File file = new File(biodataPath);
//		Reader reader = new FileReader(file);
//		char bioDataContent[] = new char[(int) file.length()];
//		// prepare Entity class obj
//		MarriageSeeker seeker = new MarriageSeeker(name, address, photoData, LocalDateTime.of(2000, 10, 9, 11, 6),
//				bioDataContent, indian);
//
//		System.out.println(service.registerMarriageSeeker(seeker));
//		reader.close();
//		is.close();
//		sc.close();

		Optional<MarriageSeeker> opt = service.searchSeekerById(252);
		if (opt.isPresent()) {
			MarriageSeeker seeker = opt.get();
			System.out.println(seeker.getId() + "," + seeker.getName() + "," + seeker.getAddrs());
			OutputStream os = new FileOutputStream("retrieve_photo.jpg");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer = new FileWriter("retrieve_biodata.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("Large objects are retrieved");
		} else {
			System.out.println("Records are not found");
		}
	}

}
