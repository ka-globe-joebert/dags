FROM openjdk:8u265

WORKDIR /jobs
COPY SimpleFileInOutJob_run.sh .
COPY lib .
COPY simplefileinoutjob_0_1.jar  .
COPY mnt/inputFile.csv /mnt
ENTRYPOINT /jobs/SimpleFileInOutJob_run.sh
