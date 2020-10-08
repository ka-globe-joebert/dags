from airflow import DAG
from airflow.operators.bash_operator import BashOperator
from datetime import datetime, timedelta
from airflow.models import DagBag; d = DagBag();


default_args = {
        'owner': 'Airflow',
        'depends_on_past': False,
        'email': ['airflow@example.com'],
        'email_on_failure': False,
        'email_on_retry': False,
        'retries': 1,
        'retry_delay': timedelta(minutes=5)
        }

dag = DAG(
        'add',
        default_args=default_args,
        start_date=datetime(2015, 12, 1),
        description='A simple add DAG',
        schedule_interval='@weekly',
        catchup=False)
