from airflow import DAG
from datetime import datetime, timedelta
from airflow.contrib.operators.kubernetes_pod_operator import KubernetesPodOperator
from airflow.operators.dummy_operator import DummyOperator


default_args = {
        'owner': 'airflow',
        'depends_on_past': False,
        'start_date': datetime.utcnow(),
        'email': ['airflow@globe.com.ph'],
        'email_on_failure': False,
        'email_on_retry': False,
        'retries': 1,
        'retry_delay': timedelta(minutes=5)
        }

dag = DAG(
        'simplefileinout', default_args=default_args, schedule_interval=timedelta(minutes=10))


simplefileinout = KubernetesPodOperator(namespace='edo-np-de',
        image="nexus.edo.globe.com.ph/repository/edo-aim-dev-docker/talend",
        cmds=["./SimpleFileInOutJob_run.sh"],
        labels={"app": "simplefileinout"},
        name="simplefileinout",
        task_id="simplefileinout-task",
        get_logs=True,
        dag=dag
        )
